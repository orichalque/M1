import org.json.simple.JSONObject;


public class gh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject();
		  obj.put("name","foo");
		  obj.put("num",new Integer(100));
		  obj.put("balance",new Double(1000.21));
		  obj.put("is_vip",new Boolean(true));
		  obj.put("nickname",null);
		  System.out.print(obj);
	}

}
