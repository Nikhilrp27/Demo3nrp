package Steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
public class HRLogin {
	
	
	public static WebDriver driver;
	String empid;
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@When("User Enters Valid Credentials")
	public void user_enters_valid_credentials(DataTable dataTable) {
	 
		String username = dataTable.cells().get(0).get(0);
		String pass = dataTable.cells().get(0).get(1);

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pass);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@When("user click on PIM page link")
	public void user_click_on_pim_page_link() throws InterruptedException {
		Thread.sleep(4000);
		 driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")).click();
		//driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}

	@When("user click on add employee ,and enter firatname , lastname and click on save button and user copy empid and click on employee list button and enter empid in empid text box and click on search and user click on bin symbol button and delete the employee")
	public void user_click_on_add_employee_and_enter_firatname_lastname_and_click_on_save_button_and_user_copy_empid_and_click_on_employee_list_button_and_enter_empid_in_empid_text_box_and_click_on_search_and_user_click_on_bin_symbol_button_and_delete_the_employee(DataTable dataTable) throws InterruptedException {
	
		
		List<List<String>> ls = dataTable.asLists();

		for (int i = 0; i < ls.size(); i++) {
			driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

			String firstname = ls.get(i).get(0);

			String lastname = ls.get(i).get(1);

			Thread.sleep(2000);

			driver.findElement(By.name("firstName")).sendKeys(firstname);

			driver.findElement(By.name("lastName")).sendKeys(lastname);

			driver.findElement(By.xpath("//button[text()=' Save '] ")).click();

			Thread.sleep(4000);
			
			empid = driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]")).getAttribute("value");
			//WebElement id = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]"));
			//empid = id.getAttribute("value");

			System.out.println(empid);
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[1]")).click();
			Thread.sleep(4000);

			driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(empid);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
	}
	}

	@When("user click on Account dropdown and click on logout")
	public void user_click_on_account_dropdown_and_click_on_logout() {
	
	}


}
