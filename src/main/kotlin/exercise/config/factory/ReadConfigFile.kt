package exercise.config.factory

import exercise.config.model.Config

interface ReadConfigFile {
  fun readConfigFile(filePath: String): Config
}