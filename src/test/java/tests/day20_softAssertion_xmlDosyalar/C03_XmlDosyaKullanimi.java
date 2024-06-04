package tests.day20_softAssertion_xmlDosyalar;

public class C03_XmlDosyaKullanimi {

    /*

        Test Cesitleri
        1- islevsel acidan
            fonksiyonel testler ve fonksiyonel olmayan testler
        2- icerik acisindan
           black-box testing ve white-box testing
        3- yapilis bicimi acisindan
           manuel testler ve otomasyon ile yapilan testler

           smoke test : islevsel acidan fonksiyonel
                        icerik acisindan black-box
                        yapilis acisindan otomasyon testidir

        Smoke Test :
        E2E Testi :
        Regression Test :
        Kullanici Kabul Testi :
        Entegrasyon Testi :

        Belirli bir amac icin calistirilan tum kodlardir.
        Bu kodlar method'lar, class'lar veya package'lar icerebilir


        Test'ler biraraya getirilerek test suite'leri olusturulabilir.


        Ornek olarak

        Bizim smoke testimiz
         - day17 package'indaki tum class'lar
         - day18'den C05 ve C06
         - day19 daki C03 class'indan gecersizEmailTesti
         - day20 deki C01 class'larindan olusuyor

        smoke testi olusturan tum kodlari tek seferde calistirip raporlamak istiyoruz

        TestNG istedigimiz konfigurasyonlarda istedigimiz sayida
        package/class ve test method'unu toplu olarak calistirabilmemiz icin
        TestNG xml dosyalari hazirlamistir

        TestNG kullanilarak toplu kod calistirmak istedigimizde
        .xml dosyalarini kullanabiliriz
        1- Kullancagimiz .xml dosyalarinin ilk satirinda
           TestNG'nin DTD dosyalarini isaret etmek icin
           <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
           satiri MUTLAKA olmalidir

        2- Bu satirin altinda hiyerarsiye uygun olarak
           suite ve test secilip sonra
           verilen goreve uygun package / class veya test method'lari secilebilir

     */
}
