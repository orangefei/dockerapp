package com.codinglab.hellodocker.dockerapp.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation._

@RequestMapping(Array("/app/redis"))
@RestController
class RedisController {
  private val log = LoggerFactory.getLogger(classOf[MerchantController])

  @Autowired
  var redisTemplate: StringRedisTemplate = _

  @GetMapping(Array("/set-username"))
  def setRedisName(@RequestParam name: String) = {
    log.info(s"设置Redis Name.")
    redisTemplate.opsForValue().set("name", name)
    log.info(s"已完成设置Redis Name.")
    true
  }

  @GetMapping(Array("/username"))
  def getNameFromRedis() = {
    log.info(s"获取Redis Name.")
    val name = redisTemplate.opsForValue().get("name")
    log.info(s"已完成获取Redis Name, name=${name}")
    name
  }
}
