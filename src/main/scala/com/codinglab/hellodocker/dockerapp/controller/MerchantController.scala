package com.codinglab.hellodocker.dockerapp.controller

import com.codinglab.hellodocker.dockerapp.service.MerchantService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/app/merchant"))
class MerchantController {

  private val log = LoggerFactory.getLogger(classOf[MerchantController])

  @Autowired
  private var merchantService: MerchantService = _

  @GetMapping(Array("/{merchantId}"))
  def getMerchant(@PathVariable merchantId: String) = {
    log.info(s"查询${merchantId}商户信息.")
    val merchant = merchantService.findByMerchantId(merchantId)
    log.info(s"查询${merchantId}商户信息,结果: ${merchant}")
    merchant
  }

  @GetMapping
  def newMerchant(@RequestParam merchantId: String,
                  @RequestParam merchantName: String) = {
    log.info(s"新增商户信息: merchantId=${merchantId}, merchantName=${merchantName}")
    val merchant = merchantService.newMerchant(merchantId, merchantName)
    log.info(s"完成新增商户信息.")
    merchant
  }
}
