package core.page

class CRMCollectorsCss {
  val header = ".collapse.navbar-collapse"
  val mainButton = "a[ui-sref='dashboard']"
  val leadsButton = "a[class='ng-binding']"
  val bodyPage = "#main"
  val collectorsFilter = ".filter-wrapper.ng-scope"
  val inputCollector = "input[type='text']"
  val dropDownType = "select[ng-model='params.type']"
  val resetLink = "a[ng-click='clearFilter()']"
  val searchButton = ".item.submit-group>button[type='submit']"
  val tableCollectors = ".table-wrapper.ng-scope"
  val tableLine = "tbody:nth-child(3)>tr.ng-scope:nth-child(1)"
  val tableFieldId = "tr.ng-scope:nth-child(1)>td.ng-binding:nth-child(1)"
  val tableFieldName = "tr.ng-scope:nth-child(1) td:nth-child(2)>a.ng-binding"
}