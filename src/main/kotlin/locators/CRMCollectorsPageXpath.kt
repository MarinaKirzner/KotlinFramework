package locators

class CRMCollectorsPageXpath {
  val header = "//div[@class='collapse navbar-collapse']"
  val buttonMain = "//a[@ui-sref='dashboard']"
  val buttonLeads = "//a[text()='Leads']"
  val bodyPage = "//div[@id='main']"
  val filterCollectors = "//div[@class='filter-wrapper ng-scope']"
  val inputCollector = "//input[@type='text']"
  val dropDownType = "//select[@ng-model='params.type']"
  val linkReset = "//a[text()='Reset']"
  val buttonSearch = "//button[text()='Search']"
  val tableCollectors = "//div[@class='table-wrapper ng-scope']"
  val tableLine = "//td[contains(text(),'212')]/parent::tr"
  val tableFieldId = "//td[contains(text(),'212')]"
  val tableFieldName = "//td[text()='212']/following-sibling::td/a"
}