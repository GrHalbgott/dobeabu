**Dokumentation zu „Dobeabu"**

Niko Kolaxidis und zwei andere

Idee:

- Figurenauswahl ermöglichen (mehrere Figuren auswählen)
- Freie Steuerung einer Figur
- Freie Steuerung der Kamera

Umsetzung:

- Erstellen einer Szenerie:
```java
hatBoden = new GLBoden("boden.jpg");
hatHimmel = new GLHimmel("sky.jpg");
hatLichtquelle = new GLLicht(5000,5000,5000);
```
- Einstellung der Kamera:
```java
hatKamera = new GLKamera();
hatKamera.setzePosition(2000,500,2000);
```
- Steuerungen:
```java
if (hatTastatur.istGedrueckt('/') == true&&hatAuge!= null)
{
    hatKamera.rotiere(359.8, 0,1,0, 0.1,0.1,0.1);
    hatAuge.rotiere(359.8, 0,1,0, 0.1,150,0.1);
}
```
- Beispiel für Tastenzuordnung zur Steuerung der Kamera (+ Überprüfung, ob später erstelltes „Auge" ungleich 0 ist: wenn = 0, dann wird diese Methode nicht ausgeführt; wenn != 0, dann wird diese Methode ausgeführt → das Auge dreht sich mit der Kamera)
```java
if(hatTastatur.istGedrueckt('s') == true&&C== true&&B== false&&D== false)
{
    hatBall.verschiebe(0,0,5);
    Sys.warte();
}
```
- Beispiel für Tastenzuordnung zur Steuerung der Figur (+ Überprüfung, ob andere Figuren gleich 0 sind, da nur eine Figur angezeigt + gesteuert werden soll)
- Figurenauswahl:
```java
if(hatTastatur.istGedrueckt('3') == true&&B== true)
{
    hatTorus.loescheDich();
    hatTorusKaese.loescheDich();
    hatTorusMeat.loescheDich();

B = false;

  if(C== false)
  {
      hatBall = new GLKugel(0.1,150,0.1,100);
      hatBall.setzeQualitaet(250);
      hatBall.setzeDrehung(90,0,0);
      hatBall.setzeTextur("flag.jpg");
  C = true;
  }
}
```
- Beispiel einer Figurenauswahl:
  - Überprüfung, ob Taste '3' gedrückt wird
  - Überprüfung, ob Figur B aktiv ist
  - Figur B wird gelöscht (Torus, TorusKaese + TorusMeat)
  - Figur B wird als 'inaktiv' gesetzt
  - Überprüfung, ob Figur C 'inaktiv'
  - Erstellung der Figur C (Ball)
  - Setzte Figur C als 'aktiv'

Handhabung:
- Rote Linie: Dient zur Orientierung (X-Achse, Ursprung in der Mitte des Kegels)
- Steuerung :
- Pfeiltasten → Kamerasteuerung x-Achse, y-Achse
- /,* → Kamerasteuerung Links, Rechts
- +,- → Kamera vor, zurück
- u   → Kamera zurücksetzen
- m   → 3D ein/aus
- w,a,s,d → Figur nach vorne, links, zurück, rechts
- q,e → Drehung der Figur x-Achse
- r,f → Figur hoch, runter
- y,c → Drehung der Figur y-Achse
- o   → Figur auf den Ursprung zurücksetzen
- 1-3 → Figurenwechsel (Saurons Auge=1, Dobeabu=2, Ball=3)
- p → Programm beenden
