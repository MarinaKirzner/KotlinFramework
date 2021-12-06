package core.page

import org.openqa.selenium.By

abstract class BaseBlock() {
  protected abstract val baseLocator: By
}