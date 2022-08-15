package modulos.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@DisplayName("Teste Mobile do Módulo de Produto")
public class ProdutoTest {

    private WebDriver app;

    @BeforeEach
    public void beforeEach()throws MalformedURLException {

            //Abrir o App
            DesiredCapabilities capacidades = new DesiredCapabilities();
            capacidades.setCapability("deviceName","Google Pixel 3");
            capacidades.setCapability("platform","Android");
            capacidades.setCapability("udid","192.168.225.101:5555");
            capacidades.setCapability("appPackage"," com.lojinha");
            capacidades.setCapability("appActivity","com.lojinha.ui.MainActivity");
            capacidades.setCapability("app","C:\\Users\\camil\\Downloads\\Lojinha+Android+Nativa\\lojinha-nativa.apk");

            this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
            this.app.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @DisplayName("Validação do Valor de Produto Não Permetido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermetido() {


        //Fazer Login
        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaAdicaoProduto()
                .preencherNomeProduto("iPhone")
                .preencherValorProduto("700001")
                .preencherCorProduto("Prata,cinza")
                .submissaoComErro()
                .obterMensagemComErro();
        //Abrir o formulario de novo Produto

        //Cadastrar um produto com valor inválido

        //Validar que a mensagem de valor inválido foi apresentada
        //= app.findElement(By.xpath("//android.widget.Toast")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }
    @AfterEach
    public void afterEach(){
       app.quit();
    }

}
