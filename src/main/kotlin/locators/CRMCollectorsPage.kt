package locators

class CRMCollectorsPage {
  val headerBlock: HeaderBlock by lazy { HeaderBlock() }
  val bodyBlock: BodyBlock by lazy { BodyBlock() }
  val filterCollectorsBlock: FilterCollectorsBlock by lazy { FilterCollectorsBlock() }
  val tableCollectorsBlock: TableCollectorsBlock by lazy { TableCollectorsBlock() }
}