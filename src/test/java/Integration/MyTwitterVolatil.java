package Integration;

import com.matheus.Exception.MFPException;
import com.matheus.Exception.PDException;
import com.matheus.Exception.PEException;
import com.matheus.Exception.PIException;
import com.matheus.Model.ITwitter;
import com.matheus.Model.MyTwitter;
import com.matheus.Model.Perfil;
import com.matheus.Model.PessoaFisica;
import com.matheus.Repository.RepositorioUsuarioVolatil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyTwitterVolatil {
    ITwitter twitter = new MyTwitter(new RepositorioUsuarioVolatil());

    @Before
    public void setUp() throws Exception {
        twitter = new MyTwitter(new RepositorioUsuarioVolatil());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateANewProfile() {
        try {
            Perfil perfil = new PessoaFisica("matheus3301");
            twitter.criarPerfil(perfil);
            twitter.tweetar("matheus3301", "Olá Mundo");
            Assert.assertEquals(1, twitter.tweets("matheus3301").size());
        } catch (PEException | PDException | PIException | MFPException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void shouldNotCreateANewProfile() {
        try {
            Perfil perfil1 = new PessoaFisica("matheus3301");
            Perfil perfil2 = new PessoaFisica("matheus3301");
            twitter.criarPerfil(perfil1);
            twitter.criarPerfil(perfil2);
            //se continuar o fluxo original, é erro!
            Assert.fail();
        } catch (PEException e) {
            Assert.assertEquals(e.getMessage(), "matheus3301");
        }
    }

    @Test
    public void shouldDisableProfile() {
        try {
            Perfil perfil = new PessoaFisica("matheus3301");
            twitter.criarPerfil(perfil);
            twitter.cancelarPerfil("matheus3301");

            twitter.tweets("matheus3301");
        } catch (PDException e) {
            Assert.assertTrue(true);
        } catch (PIException e) {
            Assert.fail();
        } catch (PEException e) {
            Assert.fail();
        }
    }

    @Test
    public void tweetar() {
        Assert.fail();

    }

    @Test
    public void timeline() {
        Assert.fail();

    }

    @Test
    public void tweets() {
        Assert.fail();

    }

    @Test
    public void seguir() {
        Assert.fail();

    }

    @Test
    public void numeroSeguidores() {
        Assert.fail();

    }

    @Test
    public void seguidores() {
        Assert.fail();

    }

    @Test
    public void seguidos() {
        Assert.fail();

    }
}