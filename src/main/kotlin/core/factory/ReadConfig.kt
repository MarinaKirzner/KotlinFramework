package core.factory

import core.model.DriverConfig

interface ReadConfig {
  fun setConfig(driverConfig: DriverConfig)
}