package core.context

import core.api.mock.model.WireMockConfig
import core.context.constant.StaticContextHolder
import core.context.dynamic.DynamicContextHolder
import core.context.dynamic.SessionContext
import core.db.model.DbClientConfig
import core.ui.crm.model.IpruCrmConfig

val sessionContext: SessionContext = DynamicContextHolder.getConfig().sessionContext
val wireMockConfig: WireMockConfig = StaticContextHolder.getConfig().wireMockConfig
val dbClientConfig: DbClientConfig = StaticContextHolder.getConfig().dbClientConfig
val ipruCrmConfig: IpruCrmConfig = StaticContextHolder.getConfig().ipruCrmConfig