package `fun`.fifu.fifusky

import `fun`.fifu.fifusky.commands.SkyCommand
import `fun`.fifu.fifusky.data.Dataer
import cn.hutool.core.io.FileUtil
import cn.hutool.core.io.resource.ClassPathResource
import cn.hutool.db.Db
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

/**
 * FiFuSky插件主类
 * @author NekokeCore
 */
class FiFuSky : JavaPlugin() {

    override fun onLoad() {
        val f = File("plugins/FiFuSky")
        if (!f.isDirectory)
            f.mkdirs()
        if (!File("plugins/FiFuSky/FiFuSky.db").isFile) {
//            val b = ClassPathResource("FiFuSky.db").readBytes()
//            FileUtil.writeBytes(b,"plugins/FiFuSky/FiFuSky.db")
            logger.warning("腐竹请注意：把本插件jar包内的 FiFuSky.db 解压到 plugins/FiFuSky/FiFuSky.db")
        }
        logger.info(Dataer.getIsLandData(Sky.getIsLand("(0,0)")).toString())
    }

    override fun onEnable() {
        //注册命令
        Bukkit.getPluginCommand("s")?.setExecutor(SkyCommand())
        //注册监听器
        //pluginManager.registerEvents(PlayerListener(), this)
        logger.info("FiFu空岛插件已启动！")
    }
}