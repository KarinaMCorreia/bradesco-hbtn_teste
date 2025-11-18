import org.junit.Test;
import static org.junit.Assert.*;

public class TesteEmail {

    @Test
    public void testar_email_com_arroba() {
        boolean resultado = Pessoa.emailValid("email_teste@dominio.com.br");
        assertTrue(resultado);
    }

    @Test
    public void testar_email_sem_arroba() {
        boolean resultado = Pessoa.emailValid("email_testedominio.com.br");
        assertFalse(resultado);
    }

    @Test
    public void testar_email_mais_50_caracteres() {
        String emailLongo = "email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br";
        boolean resultado = Pessoa.emailValid(emailLongo);
        assertEquals(false, resultado);
    }
}