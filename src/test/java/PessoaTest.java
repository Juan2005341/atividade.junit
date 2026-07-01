import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PessoaTest {

    @Test
    public void test1_1_NomeValidoComSobrenome() {
        assertDoesNotThrow(() -> {
            new Pessoa("Lucas Silva", 25);
        });
    }

    @Test
    public void test1_2_NomeSemSobrenomeLançaExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Gabriel", 30); 
        });
        assertEquals("Deve ser informado o sobrenome", exception.getMessage());
    }

    @Test
    public void test2_1_NomeComTamanhoValido() {
        assertDoesNotThrow(() -> {
            new Pessoa("Carlos Souza", 40);
        });
    }

    @Test
    public void test2_2_NomeCurtoLançaExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Ana b", 20);
        });
        assertEquals("Nome e sobrenome devem possuir mais do que 5 caracteres", exception.getMessage());
    }

    @Test
    public void test3_1_NomeApenasLetras() {
        assertDoesNotThrow(() -> {
            new Pessoa("Pedro Alves", 19);
        });
    }

    @Test
    public void test3_2_NomeComCaracterInvalidoLançaExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Juan Silva123", 22); 
        });
        assertEquals("Caracter inválido encontrado!", exception.getMessage());
    }

    @Test
    public void test4_1_IdadeLimiteInferiorValida() {
        assertDoesNotThrow(() -> {
            new Pessoa("Juan Carlos", 0);
        });
    }

    @Test
    public void test4_1_IdadeNegativaLançaExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Juan Carlos", -1);
        });
        assertEquals("Idade não pode ser negativa", exception.getMessage());
    }

    @Test
    public void test4_2_IdadeLimiteSuperiorValida() {
        assertDoesNotThrow(() -> {
            new Pessoa("Juan Carlos", 100);
        });
    }

    @Test
    public void test4_2_IdadeMaiorQueCemLançaExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Juan Carlos", 101);
        });
        assertEquals("Idade não pode ser maior que 100", exception.getMessage());
    }
}
