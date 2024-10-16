package stepdefinitions;

//import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.GuidePage;
import pageobjects.HomePage;
import pageobjects.PhotosPage;
import utils.WebDriverUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;

public class TestSteps {

    WebDriver driver;
    HomePage homePage;
    GuidePage guidePage;
    PhotosPage photosPage;

    @Before
    public void setUp() {
        driver = WebDriverUtils.getDriver("firefox"); // ou "chrome"
        homePage = new HomePage(driver);
        guidePage = new GuidePage(driver);
        photosPage = new PhotosPage(driver);
    }

    @Given("eu acesso a página inicial {string}")
    public void eu_acesso_a_pagina_inicial(String url) {
        driver.get(url);
    }

    @When("eu acesso o menu {string}")
    public void eu_acesso_o_menu(String menu) {
        homePage.clickOnGuideMenu();
    }

    @When("eu navego até o link {string}")
    public void eu_navego_ate_o_link(String link) {
        guidePage.clickOnAlbumsLink();
    }

    @Then("eu capturo os dados exibidos em tela")
    public void eu_capturo_os_dados_exibidos_em_tela() throws IOException, InterruptedException {
        List<Map<String, Object>> photosList = photosPage.getPhotosJson();

        // Itera sobre a lista e exibe os dados no console
        for (Map<String, Object> photo : photosList) {
            System.out.println("ID: " + photo.get("id"));
            System.out.println("Título: " + photo.get("title"));
            System.out.println("URL: " + photo.get("url"));
            System.out.println("Thumbnail URL: " + photo.get("thumbnailUrl"));
            System.out.println("-----------");
        }
    }
    
    @Then("eu valido os dados do objeto com id {int}")
    public void eu_valido_os_dados_do_objeto_com_id(int id, DataTable dataTable) throws IOException, InterruptedException {
        // Usando PhotosPage para obter o JSON da API
        Map<String, Object> photo = photosPage.getPhotoById(id);
        
        // Obter os dados da tabela
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        // Iterar sobre cada linha na tabela
        for (Map<String, String> row : rows) {
            assertEquals(id, photo.get("id"));
            assertEquals(row.get("title"), photo.get("title"));
            assertEquals(row.get("url"), photo.get("url"));
            assertEquals(row.get("thumbnailUrl"), photo.get("thumbnailUrl"));
        }
        
        // Exibindo no console o objeto JSON recuperado
        System.out.println("Foto com ID " + id + ": " + photo);
    }
}

