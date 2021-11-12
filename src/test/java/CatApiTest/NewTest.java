package CatApiTest;

import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NewTest {
  @Test
  public void checkTextIsNotEmpty() {
	 Response res = RestAssured.get("https://cat-fact.herokuapp.com/facts/random") ;
	 // System.out.println(res.getBody().asString());
	 String text = res.getBody().jsonPath().get("text");
	 // System.out.println(myText);
	 assertFalse(text.isEmpty());
	
  }
}
