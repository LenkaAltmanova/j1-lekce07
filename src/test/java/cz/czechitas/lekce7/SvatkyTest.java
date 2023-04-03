package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
        assertNull(svatky.kdyMaSvatek("Eva"));
    }

    @Test
    void kdyMaSvatek_proVstupNatasa_VraciHodnotu() {
        //alternativa, jak lze napsat test, aby to bylo pochopitelnější
        //arrange (připrav)
        Svatky svatky = new Svatky();
        String jmeno = "Nataša";
        MonthDay ocekavanyVysledek = MonthDay.of(5, 18);

        //act (vykonej)
        MonthDay skutecnyVysledek = svatky.kdyMaSvatek(jmeno);

        //assert (ověř)

        assertEquals(ocekavanyVysledek, skutecnyVysledek);

    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Nataša"));
        assertFalse(svatky.jeVSeznamu("Eva"));
        assertFalse(svatky.jeVSeznamu("difuzer"));
        //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
    }

    @Test
    void jeVSeznamu_Natasa() {
        //alternativa, jak lze napsat test, aby to bylo pochopitelnější
        //arrange (připrav)
        Svatky svatky = new Svatky();
        String jmeno = "Nataša";
        boolean ocekavanyVysledek = true;

        //act (vykonej)
        boolean skutecnyVysledek = svatky.jeVSeznamu(jmeno);

        //assert (ověř)
        //assertTrue(skutecnyVysledek);
        // taky možnost, ale teoreticky lepší varianta je níže, vždy porovnávat očekávání vs. skutečnost
        assertEquals(ocekavanyVysledek, skutecnyVysledek);
    }


    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */

    @Test
    void getPocetJmen() {
        //arrange
        Svatky svatky = new Svatky();
        int ocekavanyVysledek = 37;

        //act
        int skutecnyVysledek = svatky.getPocetJmen();
        //assert
        assertEquals(ocekavanyVysledek, skutecnyVysledek);
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //arrange
        Svatky svatky = new Svatky();
        int ocekavanyVysledek = 37;

        //act
        int skutecnyVysledek = svatky.getSeznamJmen().size();
        //assert
        assertEquals(ocekavanyVysledek, skutecnyVysledek);
    }


    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        //arrange
        Svatky svatky = new Svatky();
        String jmeno = "Zikmund";
        int denSvatku = 2;
        int mesicSvatku = 5;

        //act
        svatky.pridatSvatek(jmeno, denSvatku, mesicSvatku);
        MonthDay skutecneDatumSvatku = svatky.kdyMaSvatek(jmeno);
        //assert
        assertNotNull(skutecneDatumSvatku);
        assertEquals(denSvatku, skutecneDatumSvatku.getDayOfMonth());
        assertEquals(mesicSvatku, skutecneDatumSvatku.getMonthValue());
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //arrange
        Svatky svatky = new Svatky();
        String jmeno = "Laura";
        int denSvatku = 1;
        Month mesicSvatku = Month.MAY;

        //act
        svatky.pridatSvatek(jmeno, denSvatku, mesicSvatku);
        MonthDay skutecneDatumSvatku = svatky.kdyMaSvatek(jmeno);
        //assert
        assertNotNull(skutecneDatumSvatku);
        assertEquals(denSvatku, skutecneDatumSvatku.getDayOfMonth());
        assertEquals(mesicSvatku, skutecneDatumSvatku.getMonth());

        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
     */
    @Test
    void pridatSvatekMonthDay() {
        //arrange
        Svatky svatky = new Svatky();
        String jmeno = "Tamara";
        MonthDay datumSvatku = MonthDay.of(Month.JUNE, 3);

        //act
        svatky.pridatSvatek(jmeno, datumSvatku);
        MonthDay skutecneDatumSvatku = svatky.kdyMaSvatek(jmeno);
        //assert
        assertNotNull(skutecneDatumSvatku);
        assertEquals(datumSvatku, skutecneDatumSvatku);

    }

    /**
     * Testuje metodu {@link Svatky#smazatSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //arrange
        Svatky svatky = new Svatky();
        String jmeno = "Alexej";
        int ocekavanyPocetJmenPoSmazaniJednohoJmena = 36;

        //act
        svatky.smazatSvatek(jmeno);
        //assert
        assertFalse(svatky.jeVSeznamu(jmeno));
        assertEquals(ocekavanyPocetJmenPoSmazaniJednohoJmena, svatky.getPocetJmen());

    }
}
