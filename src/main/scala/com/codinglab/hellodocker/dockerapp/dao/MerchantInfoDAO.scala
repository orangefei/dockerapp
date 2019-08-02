package com.codinglab.hellodocker.dockerapp.dao

import com.codinglab.hellodocker.dockerapp.entity.MerchantInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
trait MerchantInfoDAO extends JpaRepository[MerchantInfo, Long] {
  def findByMerchantId(merchantId: String): MerchantInfo
}
