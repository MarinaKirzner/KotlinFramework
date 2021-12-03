package core.factory

import core.model.DriverConfig

interface DriverFactory {
  fun setConfig(driverConfig: DriverConfig)
}