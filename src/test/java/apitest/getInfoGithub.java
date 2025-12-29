package apitest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.ApiClient;

import java.util.List;
import java.util.Map;

public class getInfoGithub {

    Response response;
    int totalOpenIssues = 0;
    String topRepo = "";
    int maxStars = 0;

    @Given("get all repositories from SeleniumHQ")
    public void fetchRepos() {
        response = ApiClient.get("/orgs/SeleniumHQ/repos");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @When("calculate total open issues")
    public void calculateIssues() {
        List<Map<String, Object>> repos = response.jsonPath().getList("$");

        for (Map<String, Object> repo : repos) {
            totalOpenIssues += (int) repo.get("open_issues_count");
        }
    }

    @When("find repository with highest stars")
    public void findTopRepo() {
        List<Map<String, Object>> repos = response.jsonPath().getList("$");

        for (Map<String, Object> repo : repos) {
            int stars = (int) repo.get("stargazers_count");
            String name = (String) repo.get("name");

            if (stars > maxStars) {
                maxStars = stars;
                topRepo = name;
            }
        }
    }

    @Then("print the result")
    public void printResults() {

        System.out.println("Total open issues: " + totalOpenIssues);
        System.out.println("Top star repository: " + topRepo + " (" + maxStars + ")");

        Assert.assertTrue(totalOpenIssues >= 0);
        Assert.assertNotNull(topRepo);
    }
}