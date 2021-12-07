package core.page

import org.openqa.selenium.By

class HeaderBlock : BaseBlock() {
  override val baseLocator: By = By.cssSelector(".collapse.navbar-collapse")
  val mainButton = By.cssSelector("[href='#/']")
  val leadsButton = By.cssSelector("[href='#/leads']")
}

class BodyBlock() : BaseBlock() {
  override val baseLocator: By = By.id("main")
}

class FilterCollectorsBlock() : BaseBlock() {
  override val baseLocator: By = By.cssSelector(".filter-wrapper.ng-scope")
  val inputCollector: By = By.cssSelector("input")
  val dropDownType: By = By.cssSelector("[ng-model='params.type']")
  val linkReset: By = By.cssSelector("[ng-click='clearFilter()']")
  val buttonSearch: By = By.cssSelector("[type='submit']")
}

class TableCollectorsBlock() : BaseBlock() {
  override val baseLocator: By = By.cssSelector(".table-wrapper.ng-scope")
  val tableLine: By = By.cssSelector("tr.ng-scope:nth-child(1)")
  val tableFieldId: By = By.cssSelector("td.ng-binding:nth-child(1)")
  val tableFieldName: By = By.cssSelector("td:nth-child(2)>a.ng-binding")
}