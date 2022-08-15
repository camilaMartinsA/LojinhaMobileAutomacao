package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.Normalizer;

public class FormularioAdicaoProdutoTela extends BaseTela{

    public FormularioAdicaoProdutoTela(WebDriver app){
        super(app);
    }


    public  FormularioAdicaoProdutoTela preencherNomeProduto(String produtoNome){
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);

        return this;

    }
    public FormularioAdicaoProdutoTela preencherValorProduto(String valorProduto ){
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(valorProduto);

        return this;
    }
    public FormularioAdicaoProdutoTela preencherCorProduto(String produtoCor){
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoCor);

        return this;
    }
    public FormularioAdicaoProdutoTela submissaoComErro(){
        app.findElement(By.id("com.lojinha:id/saveButton")).click();

        return this;
    }
    public String obterMensagemComErro(){
        return capturarToast();
    }
}
