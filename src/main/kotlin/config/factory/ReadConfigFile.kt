package config.factory

import config.model.Config

interface ReadConfigFile {
  fun readConfigFile(filePath: String): Config
}