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
        Boolean ocekavanyVysledek = true;

        //act (vykonej)
        Boolean skutecnyVysledek = svatky.jeVSeznamu(jmeno);

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
        String jmeno = "Laura";
        int den = 1;
        int mesic = 6;

        //act
        svatky.pridatSvatek(jmeno, den, mesic);
        //boolean jmenoJeSkutecneVSeznamu = svatky.jeVSeznamu("Laura");
        //assert
        assertTrue(svatky.jeVSeznamu(jmeno));
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //arrange
        Svatky svatky = new Svatky();
        String jmeno = "Laura";
        int den = 1;
        Month mesic = Month.MAY;

        //act
        svatky.pridatSvatek(jmeno, den, mesic);
        //assert
        assertTrue(svatky.jeVSeznamu(jmeno));
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay, Month)}
     */
    @Test
    void prridatSvatekMonthDay() {
        //arrange
        Svatky svatky = new Svatky();
        String jmeno = "Tamara";
        MonthDay den = MonthDay.of(Month.JUNE, 3);

        //act
        svatky.pridatSvatek(jmeno, den);
        //assert
        assertTrue(svatky.jeVSeznamu(jmeno));
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#smazatSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //arrange
        Svatky svatky = new Svatky();
        String jmeno = "Alexej";

        //act
        svatky.getSeznamJmen().remove(jmeno);
        //assert
        assertFalse(svatky.jeVSeznamu(jmeno));
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
    }
}
