// JSON 데이터 받고 보내기 - 외부 라이브러리 사용하여 처리하기(google-gson)
package ex02;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/ex02/test21")
public class Test21 {

    // 테스트
    //      http://localhost:8888/ex02/Test21.html
    //

    // 방법1) 클라이언트가 보낸 JSON 데이터를 변수에 받아서 페이지 컨트롤러가 처리하기
    // => 문자열을 자바 객체로 변환시켜줄 라이브러리를 추가해야 한다.
    //    google의 gson 라이브러리를 사용해보자!
    @Autowired ServletContext sc;

    @SuppressWarnings("unchecked")
    @RequestMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(@RequestBody String jsonData) throws Exception {
        System.out.println(jsonData);


        // JSON 데이터를 deserialize
        Gson gson = new Gson();
        Car car = gson.fromJson(jsonData, Car.class);

        System.out.printf("model=%s\n",car.getModel());
        System.out.printf("maker=%s\n",car.getMaker());
        System.out.printf("auto=%b\n",car.isAuto());

        // JSON 데이터를 Map 객체로도 만들 수 있다.
        Map<String,Object> map=gson.fromJson(jsonData, Map.class);
        System.out.printf("model=%s\n",map.get("model"));
        System.out.printf("maker=%s\n",map.get("maker"));
        System.out.printf("auto=%s\n",map.get("auto"));

        return "ex02.Test21.m1()";
    }

    @RequestMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2() throws Exception {

        // JSON 데이터를 deserialize
        Car car = new Car();
        car.setModel("소나타");
        car.setMaker("비트자동차");
        car.setAuto(true);
        car.setCreateDate(Date.valueOf("2018-10-25"));

        car.setEngine(new Engine("비트엔진",5000,32));
        car.setMusics(new String[]{"오호라!","만다린","왕치킨"});

        car.setTires(new Tire[] {
                new Tire("비트타이어",65),
                new Tire("비트타이어",65),
                new Tire("비트타이어",65),
                new Tire("비트타이어",65)
        });
        /*GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer());*/
        //return gson.toJson(car); 이게 아래와 같이 줄여짐;;

        return new GsonBuilder()
                .registerTypeAdapter(Date.class,
                        new DateSerializer() {
                            public JsonElement serialize(
                                    Date src, Type typeOfSrc, JsonSerializationContext context) {
                                    return new JsonPrimitive(src.toString());
                    }
                })
                .create()
                .toJson(car);

    }

    class DateSerializer implements JsonSerializer<Date>{

        @Override
        public JsonElement serialize(
                Date src, Type typeOfSrc, JsonSerializationContext context) {

            return new JsonPrimitive(src.toString());


        }
    }



}
