 Segítségedre lehet:	- https://developers.google.com
 						- http://infobarkacs.hu/index.php/topic,9608.msg83171/topicseen.html

 Android Studio segítségével generáltassunk egy Google Maps activity projektet
 majd általam megadott két fájl közül az egyik tartalmát egy az egyben használhatjuk ( activity_maps.xml )
 míg a java fájl tartalmából csak bizonyos részek kellenek csak.
 Tehát a generált activity_maps.xml fájlod tartalmát írasd felül az általam közzé tettel
 míg a java fájlban // Begin és // End-ek közé írtam azokat a részeket amiket nem generál le neked a studio.
 Ezeket megfelelő helyekre illesszük be az általad generált projekt fájlba.
 
 Hasonló elérési útvonalon találod a fájljaid:
/ELÉRÉSI_ÚTVONAL/PROJECT_NAME/app/src/main/java/com/example/aximcore/PROJECT_NAME/MapsActivity.java
/ELÉRÉSI_ÚTVONAL/PROJECT_NAME/app/src/main/res/layout/activity_maps.xml

Szükséged lesz egy API kulcsra amit a https://code.google.com/apis/console/ oldalon tudsz generálni. Itt kapcsold be a 
Google Maps Android API v2 api-t. A kulcs generáláshoz szükséged lesz egy másik kulcsra is ami /ELÉRÉSI_ÚTVONAL/PROJECT_NAME/app/src/debug/res/values/google_maps_api.xml 
fájlban van és hasonló ehhez :  0F:F2:55:A6:07:F8:7D:6D:25:B8:4F:C9:0F:DB:F9:74:19:82:A5:E5;com.example.aximcore.myapplication ezt megadod Public API access
kulcs generálása közben, ha ez meg van a kapott kulcsot ugyan ebbe a google_maps_api.xml fájlba YOUR_KEY_HERE helyére bemásolod.
