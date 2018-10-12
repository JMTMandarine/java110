package ex02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Member member) throws DaoException {
        PreparedStatement stmt = null;
        Connection con = null;

        try {
            con = dataSource.getConnection();
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values(?,?,password(?),?,now())";
            stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
            stmt.setString(4, member.getTel());
            stmt.executeUpdate();

            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int no = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();

            member.setNo(no);
            return 1;

        } catch (Exception e) {
            throw new DaoException(e);

        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }

    public int delete(int no) throws DaoException {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = dataSource.getConnection();
            String sql = "delete from p1_memb where mno=?";
            stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);

        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }

    public List<Member> findAll() throws DaoException {

        ArrayList<Member> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();

            String sql="select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel" + 
                    " from p1_memb m"; 
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();


            while (rs.next()) {
                Member m = new Member();
                m.setNo(rs.getInt("mno"));
                m.setEmail(rs.getString("email"));
                m.setName(rs.getString("name"));
                m.setTel(rs.getString("tel"));

                list.add(m);
            }
        } catch (Exception e) {
            throw new DaoException(e);

        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        return list;
    }


}








