package arc.knowledge.share.main;

public class StringTreatment {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * The Strings in double quotes are literals. So,  "Amitabh" will be created once in String constant pool. 
		 * And its reference will be shared between key1 and key2 and the reference will be saved in stack memory. 
		 * */
		String key1 = "Amitabh";		
		String key2 = "Amitabh";
		
		/*
		 * String in double quotes are literals. "Roy" is not present in pool, so it will be created in String constant pool. 
		 * And its reference key3 will be saved in stack memory. 
		 * */
		String key3 = "Roy";
		
		/*
		 * The new operator is used to create objects in heap outside the pool memory. 
		 * So,  "Amitabh" will be created in heap outside the pool memory. Same for "Roy" .
		 * And their references key4, key5 will be saved in stack memory. 
		 * */
		String key4 = new String("Amitabh");
		String key5 = new String("Roy");
		
		/*
		 * Here, new operator has been used with intern(). 
		 * intern() will make sure to return the reference of a string from pool. And we know that "Amitabh" is already present in pool, due to code execution at line 10.
		 * So, the same reference is returned to key10. no new object is created in heap. not even in pool. 
		 * */
		String key10 = new String("Amitabh").intern();
		
		/*
		 * let us verify what have we explained above regarding the memory space where these objects will get stored.
		 * */
		
		System.out.println(key1 == key2);// this gives true. reason is explained line 7-8.
		System.out.println(key1 == key4);// this gives false. reason : key1 refers object in pool and key4 refers object in heap.
		System.out.println(key3 == key5);// this gives false. reason : key3 refers object in pool and key5 refers object in heap.
		System.out.println(key1 == key10);// this gives true. reason : key1 refers object in pool and key10 refers object in pool due to intern().
		
		/********Some more examples *******/
		
		String key20 = "Kumar";
		String key30 = "Sinha";
		String key40 = key20 + key30;
		String key50 = key20 + "Sinha";
		String key60 = "KumarSinha";
		String key70 = key20.concat(key30);
		
		System.out.println("...........");
		System.out.println(key20 == key30);// this gives false. reason: both refer to different objects in string pool.
		System.out.println(key40 == key50);//false
		System.out.println(key40 == key60);//false
		System.out.println(key50 == key60);//false
		System.out.println(key60 == key70);//false
		Thread.sleep(120000);
	}

}
