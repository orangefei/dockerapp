package com.codinglab.hellodocker.dockerapp.service

import java.util.{Date, UUID}

import com.codinglab.hellodocker.dockerapp.dao.MerchantInfoDAO
import com.codinglab.hellodocker.dockerapp.entity.MerchantInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MerchantService {

  @Autowired
  var merchantInfoDAO: MerchantInfoDAO = _

  /**
    * 根据商户Id查询商户
    * @param merchantId
    * @return
    */
  def findByMerchantId(merchantId: String): MerchantInfo = {
    merchantInfoDAO.findByMerchantId(merchantId)
  }

  /**
    * 新建商户
    * @param merchantId
    * @param merchantName
    * @return
    */
  def newMerchant(merchantId: String, merchantName: String) = {
    val m = new MerchantInfo()
    val current = new Date()

    m.setMerchantId(merchantId)
    m.setMerchantName(merchantName)
    m.setSecurityKey(randGenSecurityKey)
    m.setStatus(1)
    m.setCreatedBy("SYSTEM")
    m.setCreatedDate(current)
    m.setUpdatedBy("SYSTEM")
    m.setUpdatedDate(current)

    merchantInfoDAO.save(m)
  }

  /**
    * 随机生成加密Key
    * @return
    */
  def randGenSecurityKey: String = {
    UUID.randomUUID().toString.replace("-", "")
  }
}
