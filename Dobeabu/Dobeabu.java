import GLOOP.*;
/**
 * @author 
 * @version 
 */
public class Dobeabu
{
    private GLKamera hatKamera;
    private GLLicht hatLichtquelle;
    private GLBoden hatBoden;
    private GLHimmel hatHimmel;
    private GLTafel hatTafel;
    private GLTastatur hatTastatur;
    private GLTorus hatTorus;
    private GLKugel hatAuge;
    private GLKegel hatKegel;
    private GLTorus hatTorusKaese;
    private GLTorus hatTorusMeat;
    private GLQuader hatX;
    private GLKugel hatBall;
    private GLKugel hatFace;
    private GLQuader hatQuader;
    private GLQuader hatQuader2;
    private GLZylinder hatZylinder;
    private GLKegelstumpf hatKegelstumpf;
    private GLPrismoid hatPrismoid;
    
    private Items hatItems;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean K;
    
    // Konstruktor
    public Dobeabu()
    {
        hatKamera = new GLKamera();
        hatLichtquelle = new GLLicht(5000,5000,5000);
        hatBoden = new GLBoden("boden.jpg");
        hatHimmel = new GLHimmel("sky.jpg");
        hatTastatur = new GLTastatur();
        
        A = false;
        B = false;
        C = false;
        
        hatTorus = new GLTorus(0.1,115,0.1, 82, 50);
        hatKegel = new GLKegel(0.1,0.1,0.1, 250, 250);
        hatTorusKaese = new GLTorus(0.1,122,0.1,82,40);
        hatTorusMeat = new GLTorus(0.1,108,0.1,82,50);
        
        hatX = new GLQuader(245,0.1,0.1, 500,10,10);
        
        /**  Objekteinstellungen
         */
        
        hatKegel.setzeQualitaet(1000);
        hatKegel.setzeDrehung(90,0,0);
        hatKegel.setzeTextur("flag.jpg");
        
        K = true;
        
        hatTorus.setzeQualitaet(100);
        hatTorusKaese.setzeQualitaet(100);
        hatTorusMeat.setzeQualitaet(100);
        
        hatTorusKaese.setzeSkalierung(1.2,1.2,0.1);
        hatTorusMeat.setzeSkalierung(1.2,1.2,0.3);

        hatTorus.setzeDrehung(90,0,0);
        hatTorusKaese.setzeDrehung(90,0,0);
        hatTorusMeat.setzeDrehung(90,0,0);
        
        hatTorusKaese.setzeTextur("kaese.jpg");
        hatTorusMeat.setzeTextur("meat.jpg");
        hatTorus.setzeTextur("bread.jpg");
        
        B = true;
        
        hatX.setzeFarbe(1,0,0);
        
        /**  Kameraeinstellungen
         */
        
        hatKamera.setzePosition(2000,500,2000);
        
        while(true)
        {
            this.bearbeiteTastendruckKamera();
            this.bearbeiteTastendruckBewegung();
            this.bearbeiteTastendruckExtras();
            Sys.warte();
        }
    }
    
    public void bearbeiteTastendruckKamera()
    {
        if(hatTastatur.istGedrueckt('/') == true && hatAuge != null)
        {
            hatKamera.rotiere(359.8, 0,1,0, 0.1,0.1,0.1);
            hatAuge.rotiere(359.8, 0,1,0, 0.1,150,0.1);
            Sys.warte();
        }
        if(hatTastatur.istGedrueckt('/') == true && hatAuge == null)
        {
            hatKamera.rotiere(359.8, 0,1,0, 0.1,0.1,0.1);
            Sys.warte();
        }
        if(hatTastatur.istGedrueckt('*') == true && hatAuge != null)
        {
            hatKamera.rotiere(0.2, 0,1,0, 0.1,0.1,0.1);
            hatAuge.rotiere(0.2, 0,1,0, 0.1,150,0.1);
            Sys.warte();
        }
        if(hatTastatur.istGedrueckt('*') == true && hatAuge == null)
        {
            hatKamera.rotiere(0.2, 0,1,0, 0.1,0.1,0.1);
            Sys.warte();
        }
        if(hatTastatur.oben() == true && hatAuge != null)
        {
            hatKamera.rotiere(359.8, 1,0,0, 0.1,0.1,0.1);
            hatAuge.rotiere(359.8, 1,0,0, 0.1,150,0.1);
            Sys.warte();
        }
        if(hatTastatur.oben() == true && hatAuge == null)
        {
            hatKamera.rotiere(359.8, 1,0,0, 0.1,0.1,0.1);
            Sys.warte();
        }
        if(hatTastatur.unten() == true && hatAuge != null)
        {
            hatKamera.rotiere(0.2, 1,0,0, 0.1,0.1,0.1);
            hatAuge.rotiere(0.2, 1,0,0, 0.1,150,0.1);
            Sys.warte();
        }
        if(hatTastatur.unten() == true && hatAuge == null)
        {
            hatKamera.rotiere(0.2, 1,0,0, 0.1,0.1,0.1);
            Sys.warte();
        }
        if(hatTastatur.rechts() == true && hatAuge == null)
        {
            hatKamera.rotiere(359.8, 0,0,1, 0.1,0.1,0.1);
            Sys.warte();
        }
        if(hatTastatur.rechts() == true && hatAuge != null)
        {
            hatKamera.rotiere(359.8, 0,0,1, 0.1,0.1,0.1);
            hatAuge.rotiere(359.8, 0,-1,0, 0.1,150,0.1);
            Sys.warte();
        }
        if(hatTastatur.links() == true && hatAuge == null)
        {
            hatKamera.rotiere(0.2, 0,0,1, 0.1,0.1,0.1);
            Sys.warte();
        }
        if(hatTastatur.links() == true && hatAuge != null)
        {
            hatKamera.rotiere(0.2, 0,0,1, 0.1,0.1,0.1);
            hatAuge.rotiere(0.2, 0,-1,0, 0.1,150,0.1);
            Sys.warte();
        }
        if(hatTastatur.istGedrueckt('+') == true)
        {
            hatKamera.vor(17);
            Sys.warte();
        }
        if(hatTastatur.istGedrueckt('-') == true)
        {
            hatKamera.vor(-17);
            Sys.warte();
        }
    }
    
    public void bearbeiteTastendruckBewegung()
    {
        int hoehe = 118;
        if(hoehe >= 100 && A == false)
        {
            if(hatTastatur.istGedrueckt('s') == true && B == true && C == false)
            {
                hatTorus.verschiebe(0,0,5);
                hatTorusKaese.verschiebe(0,0,5);
                hatTorusMeat.verschiebe(0,0,5);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('s') == true && C == true && B == false)
            {
                hatBall.verschiebe(0,0,5);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('s') == true && B == false && C == false)
            {
                hatQuader2.verschiebe(0,0,5);
                hatFace.verschiebe(0,0,5);
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('w') == true && B == true && C == false)
            {
                hatTorus.verschiebe(0,0,-5);
                hatTorusKaese.verschiebe(0,0,-5);
                hatTorusMeat.verschiebe(0,0,-5);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('w') == true && C == true && B == false)
            {
                hatBall.verschiebe(0,0,-5);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('w') == true && B == false && C == false)
            {
                hatQuader2.verschiebe(0,0,-5);
                hatFace.verschiebe(0,0,-5);
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('d') == true && B == true && C == false)
            {
                hatTorus.verschiebe(5,0,0);
                hatTorusKaese.verschiebe(5,0,0);
                hatTorusMeat.verschiebe(5,0,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('d') == true && C == true && B == false)
            {
                hatBall.verschiebe(5,0,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('d') == true && B == false && C == false)
            {
                hatQuader2.verschiebe(5,0,0);
                hatFace.verschiebe(5,0,0);
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('a') == true && B == true && C == false)
            {
                hatTorus.verschiebe(-5,0,0);
                hatTorusKaese.verschiebe(-5,0,0);
                hatTorusMeat.verschiebe(-5,0,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('a') == true && C == true && B == false)
            {
                hatBall.verschiebe(-5,0,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('a') == true && B == false && C == false)
            {
                hatQuader2.verschiebe(-5,0,0);
                hatFace.verschiebe(-5,0,0);
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('r') == true && B == true && C == false)
            {
                hatTorus.verschiebe(0,7,0);
                hatTorusKaese.verschiebe(0,7,0);
                hatTorusMeat.verschiebe(0,7,0);
                hoehe = hoehe + 7;
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('r') == true && C == true && B == false)
            {
                hatBall.verschiebe(0,7,0);
                hoehe = hoehe + 7;
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('r') == true && B == false && C == false)
            {
                hatQuader2.verschiebe(0,7,0);
                hatFace.verschiebe(0,7,0);
                hoehe = hoehe + 7;
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('f') == true && B == true && C == false)
            {
                hatTorus.verschiebe(0,-7,0);
                hatTorusKaese.verschiebe(0,-7,0);
                hatTorusMeat.verschiebe(0,-7,0);
                hoehe = hoehe - 7;
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('f') == true && C == true && B == false)
            {
                hatBall.verschiebe(0,-7,0);
                hoehe = hoehe - 7;
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('f') == true && B == false && C == false)
            {
                hatQuader2.verschiebe(0,-7,0);
                hatFace.verschiebe(0,-7,0);
                hoehe = hoehe - 7;
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('q') == true && B == true && C == false)
            {
                hatTorus.drehe(1,0,0);
                hatTorusKaese.drehe(1,0,0);
                hatTorusMeat.drehe(1,0,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('q') == true && C == true && B == false)
            {
                hatBall.drehe(1,0,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('q') == true && B == false && C == false)
            {
                hatFace.drehe(1,0,0);
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('e') == true && B == true && C == false)
            {
                hatTorus.drehe(-1,0,0);
                hatTorusKaese.drehe(-1,0,0);
                hatTorusMeat.drehe(-1,0,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('e') == true && C == true && B == false)
            {
                hatBall.drehe(-1,0,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('e') == true && B == false && C == false)
            {
                hatFace.drehe(-1,0,0);
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('y') == true && B == true && C == false)
            {
                hatTorus.drehe(0,1,0);
                hatTorusKaese.drehe(0,1,0);
                hatTorusMeat.drehe(0,1,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('y') == true && C == true && B == false)
            {
                hatBall.drehe(0,1,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('y') == true && B == false && C == false)
            {
                hatQuader.drehe(0,5,0);
                hatQuader2.drehe(0,3,0);
                hatFace.drehe(0,1,0);
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('c') == true && B == true && C == false)
            {
                hatTorus.drehe(0,-1,0);
                hatTorusKaese.drehe(0,-1,0);
                hatTorusMeat.drehe(0,-1,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('c') == true && C == true && B == false)
            {
                hatBall.drehe(0,-1,0);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('c') == true && B == false && C == false)
            {
                hatQuader.drehe(0,-5,0);
                hatQuader2.drehe(0,-3,0);
                hatFace.drehe(0,-1,0);
                Sys.warte();
            }
            
            if(hatTastatur.istGedrueckt('o') == true && B == true && C == false)
            {
                hatTorus.setzePosition(0.1,115,0.1);
                hatTorusKaese.setzePosition(0.1,118,0.1);
                hatTorusMeat.setzePosition(0.1,104,0.1);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('o') == true && C == true && B == false)
            {
                hatBall.setzePosition(0.1,115,0.1);
                Sys.warte();
            }
            if(hatTastatur.istGedrueckt('o') == true && B == false && C == false)
            {
                hatQuader.setzePosition(0.1,0.1,0.1);
                hatQuader2.setzePosition(0.1,75,0.1);
                hatFace.setzePosition(0.1,150,0.1);
                Sys.warte();
            }
        }
        if(hoehe >= 100 && hatTastatur.istGedrueckt('o') == true && hatAuge != null)
        {
                hatAuge.loesche();
                Sys.warte();
                hatKamera.setzePosition(2000,250,2000);
                hatKamera.setzeBlickpunkt(1,1,1);
                hatKamera.setzeScheitelrichtung(1,1,1);
                hatAuge = new GLKugel(0.1,150,0.1,100);
                hatAuge.setzeQualitaet(250);
                hatAuge.setzeDrehung(90,127,0);
                hatAuge.setzeTextur("auge.jpg");
                hatAuge.setzeSelbstleuchten(0.7,0.2,0.5);
                Sys.warte();
        }
    }
    
    public void bearbeiteTastendruckExtras()
    {
        if(hatTastatur.istGedrueckt('u') == true)
        {
            hatKamera.setzePosition(2000,250,2000);
            hatKamera.setzeBlickpunkt(1,1,1);
            hatKamera.setzeScheitelrichtung(1,1,1);
            Sys.warte();
        }
        if(hatTastatur.istGedrueckt('m') == true)
        {
            hatKamera.setzeStereomodus(true);
            Sys.warte();
            if(hatTastatur.istGedrueckt('m') == true)
            {
                hatKamera.setzeStereomodus(false);
                Sys.warte();
            }
        }
        if(hatTastatur.istGedrueckt('p') == true)
        {
            Sys.beenden();
        }
        
        
        if(hatTastatur.istGedrueckt('1') == true && B == true)
        {
            hatKamera.setzePosition(2000,250,2000);
            hatKamera.setzeBlickpunkt(1,1,1);
            hatKamera.setzeScheitelrichtung(1,1,1);
            
            hatTorus.loesche();
            hatTorusKaese.loesche();
            hatTorusMeat.loesche();

            B = false;
            
            if(A == false)
            {
                hatAuge = new GLKugel(0.1,150,0.1,100);
                hatAuge.setzeQualitaet(250);
                hatAuge.setzeDrehung(90,127,0);
                hatAuge.setzeTextur("auge.jpg");
                hatAuge.setzeSelbstleuchten(0.7,0.2,0.5);
                A = true;
            }
        }
        if(hatTastatur.istGedrueckt('1') == true && C == true)
        {
            hatKamera.setzePosition(2000,250,2000);
            hatKamera.setzeBlickpunkt(1,1,1);
            hatKamera.setzeScheitelrichtung(1,1,1);
            
            hatBall.loesche();

            C = false;
            
            if(A == false)
            {
                hatAuge = new GLKugel(0.1,150,0.1,100);
                hatAuge.setzeQualitaet(250);
                hatAuge.setzeDrehung(90,127,0);
                hatAuge.setzeTextur("auge.jpg");
                hatAuge.setzeSelbstleuchten(0.7,0.2,0.5);
                A = true;
            }
        }
        
        if(hatTastatur.istGedrueckt('2') == true && A == true)
        {
            hatAuge.loesche();
            
            A = false;
            
            if(B == false)
            {
                hatTorus = new GLTorus(0.1,115,0.1, 82, 50);
                hatTorusKaese = new GLTorus(0.1,122,0.1,82,40);
                hatTorusMeat = new GLTorus(0.1,108,0.1,82,50);
                hatTorus.setzeQualitaet(100);
                hatTorusKaese.setzeQualitaet(100);
                hatTorusMeat.setzeQualitaet(100);
                hatTorusKaese.setzeSkalierung(1.2,1.2,0.1);
                hatTorusMeat.setzeSkalierung(1.2,1.2,0.3);
                hatTorus.setzeDrehung(90,0,0);
                hatTorusKaese.setzeDrehung(90,0,0);
                hatTorusMeat.setzeDrehung(90,0,0);
                hatTorusKaese.setzeTextur("kaese.jpg");
                hatTorusMeat.setzeTextur("meat.jpg");
                hatTorus.setzeTextur("bread.jpg");
                B = true;
            }
        }
        if(hatTastatur.istGedrueckt('2') == true && C == true)
        {
            hatBall.loesche();
            
            C = false;
            
            if(B == false)
            {
                hatTorus = new GLTorus(0.1,115,0.1, 82, 50);
                hatTorusKaese = new GLTorus(0.1,122,0.1,82,40);
                hatTorusMeat = new GLTorus(0.1,108,0.1,82,50);
                hatTorus.setzeQualitaet(100);
                hatTorusKaese.setzeQualitaet(100);
                hatTorusMeat.setzeQualitaet(100);
                hatTorusKaese.setzeSkalierung(1.2,1.2,0.1);
                hatTorusMeat.setzeSkalierung(1.2,1.2,0.3);
                hatTorus.setzeDrehung(90,0,0);
                hatTorusKaese.setzeDrehung(90,0,0);
                hatTorusMeat.setzeDrehung(90,0,0);
                hatTorusKaese.setzeTextur("kaese.jpg");
                hatTorusMeat.setzeTextur("meat.jpg");
                hatTorus.setzeTextur("bread.jpg");
                B = true;
            }
        }
        
        if(hatTastatur.istGedrueckt('3') == true && A == true)
        {
            hatAuge.loesche();
            
            A = false;
            
            if(C == false)
            {
                hatBall = new GLKugel(0.1,150,0.1,100);
                hatBall.setzeQualitaet(250);
                hatBall.setzeDrehung(90,0,0);
                hatBall.setzeTextur("flag.jpg");
                C = true;
            }
        }
        if(hatTastatur.istGedrueckt('3') == true && B == true)
        {
            hatTorus.loesche();
            hatTorusKaese.loesche();
            hatTorusMeat.loesche();
            
            B = false;
            
            if(C == false)
            {
                hatBall = new GLKugel(0.1,150,0.1,100);
                hatBall.setzeQualitaet(250);
                hatBall.setzeDrehung(90,0,0);
                hatBall.setzeTextur("flag.jpg");
                C = true;
            }
        }
    }
}

