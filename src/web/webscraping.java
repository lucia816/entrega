
    package web;


import okhttp3.Handshake;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

    public class webscraping {
        public static void Busqueda1() {
            String exePath = "C:\\Users\\HP\\Downloads\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", exePath);

            WebDriver pagina1 = new FirefoxDriver();
            WebDriver pagina2 = new FirefoxDriver();
            WebDriver pagina3 = new FirefoxDriver();

            pagina1.get("https://fnac.es");
            pagina2.get("http://www.phonehouse.es");

            Scanner teclado = new Scanner(System.in);
            System.out.println("¿Que desea buscar?");
            String Busqueda = teclado.nextLine();

    /*    try {
            WebElement ventanaCookies = pagina1.findElement(By.id("onetrust-banner-sdk"));
            if (ventanaCookies != null) {
                System.out.println("Detectado caja de cookies");
                ventanaCookies.click();
            }
            WebElement ventanasCookies2 = pagina2.findElement(By.xpath("/html/body/div[6]"));
            if (ventanaCookies != null) {
                System.out.println("Detectado caja de cookies");
                ventanaCookies.click();
            }

        } catch (Exception e) {
        }*/

            WebElement cajaBusqueda = pagina1.findElement(By.id("Fnac_Search"));
            cajaBusqueda.sendKeys(Busqueda);
            cajaBusqueda.submit();

            WebElement cajaBusqueda2 = pagina2.findElement(new By.ById("searcher"));
            cajaBusqueda2.sendKeys(Busqueda );
            cajaBusqueda2.sendKeys(Keys.ENTER);

            List<WebElement> resultados1 = pagina1.findElements(By.xpath("/html/body/div[3]/div/div[7]/div"));
            System.out.println("Resultados pagina1  \n" +resultados1);
            System.out.println("-------------------------------------");

            WebElement elementoActuald1,precio1;
          /*  int m = 1;
            for (int n=0; n<resultados1.size();n++){
                elementoActuald1 = resultados1.get(n);
                while (m!=10) {
                    precio1 = elementoActuald1.findElement(By.xpath("/html/body/div[3]/div/div[7]/div/div[" + m + "]" + "/article/div[3]/div/div/div/div/div[1]"));
                    System.out.println(m + " " + precio1.getText());
                    m++;
                }
            }*/


            String resultados2 = pagina2.findElement(By.id("productsList")).getText();
            System.out.println("Resultados pagina2 \n" + resultados2);

           /* WebElement elementoActuald,descripcion;
            int k = 1;
            for (int i=0; i<resultados2.size();i++){
                elementoActuald = resultados2.get(i);
                while (k!=10) {
                    descripcion = elementoActuald.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/section[2]/div[2]/ul/div/div/li[" + k + "]" + "/div/div[1]/div[2]/div[1]/a"));
                    System.out.println(k + " " + descripcion.getText());
                    k++;
                }
            }*/
          /*  WebElement elementoActualp, precio;
            int j = 1;
            for (int i=0; i<resultados2.size();i++){
                elementoActualp = resultados2.get(i);
                while (j!=10) {
                    precio = elementoActualp.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/section[2]/div[2]/ul/div/div/li[" + j + "]" + "/div/div[2]/div[1]/div[1]"));
                    System.out.println(j + " " + precio.getText());
                    
                    j++;
                }
                }*/





            try {
                FileWriter fichero = new FileWriter(
                        "C:\\Users\\HP\\IdeaProjects\\Dam\\src\\entrega4\\entrega4\\webscraping.txt", true);
                PrintWriter pw = new PrintWriter(fichero);
                pw.println("Resultados de busqueda");



            } catch (Exception e) {
            }


        }

    }

