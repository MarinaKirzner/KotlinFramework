package config

import data_class.ConfigFile

interface ReadConfigFile {
  fun readConfigFile(): ConfigFile
}