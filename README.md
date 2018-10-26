# EasyDatabase

This library is to handle all you database needs.

# How to Integrate - 

1. Add this to Project level gardle file.

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2. Add this to your App level gradle file.
```
	dependencies {
		implementation 'com.github.bibutikoley:EasyDatabase:1.0'
	}
```
 Thats it..

# How to use -

Create a Java Class Extending Application and add this Line
```
public class YouClassName extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EasyDB.init(this);
    }
    
}
```
Don't forget to add this file to your Manifest.xml

After doing this.. Use it Like this

for custom object
```
       class User{
              public Name;
              public Age;
              }
              
       User user = new User();
       
       EasyDB.put("TAG_DATA_OBJECT",user)
       User userNew = EasyDB.getObject("TAG_DATA_OBJECT", User.class);
```
       
for custom arraylist
```
       ArrayList<User> userArrayList = new ArrayList<>();
       userArrayList.add(new User("Tony",12));
       userArrayList.add(new User("Jarvis",11));
       
       EasyDB.put("TAG_DATA_ARRAYLIST",userArrayList);
       ArrayList<User> userArrayListNew = EasyDB.getArrayList("TAG_DATA_ARRAYLIST", User.class);
```
       
for String
```
       EasyDB.put("TAG_DATA_STRING","Hello World");
       String Hi = EasyDB.getString("TAG_DATA_STRING"); //Hi = "Hello World"
```
       
       
for StringSet
```
       Set<String> strings = new HashSet<>();
       strings.add("one");
       strings.add("two");
       strings.add("three");
       EasyDB.put("TAG_DATA_STRING_SET",strings);
       Set<String> stringsNew = EasyDB.getStringSet("TAG_DATA_STRING_SET");
```

       
for int
```
       EasyDB.put(7,"TAG_DATA_INT");
       int i = EasyDB.getInt("TAG_DATA_INT"); //i = 7
```

       
for long
```
       EasyDB.put("TAG_DATA_LONG",12345564);
       long i = EasyDB.getLong("TAG_DATA_LONG"); //i = 12345564
```

       
for float
```
       EasyDB.put("TAG_DATA_INT",5.0f);
       int i = EasyDB.getInt("TAG_DATA_FLOAT"); //i = 5.0f
```    
   
   
for boolean
```
       EasyDB.put("TAG_DATA_BOOLEAN",true);
       boolean val = EasyDB.getBoolean("TAG_DATA_BOOLEAN"); //val = true;
```
