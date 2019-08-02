package com.codinglab.hellodocker.dockerapp.entity

import java.util.Date

import javax.persistence._
import org.apache.commons.lang.builder.{ReflectionToStringBuilder, ToStringStyle}

import scala.beans.BeanProperty

@Entity
@Table(name = "merchant_info")
class MerchantInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  /**
    * 商户ID，全局唯一
    */
  @BeanProperty
  var merchantId: String = _

  @beans.BeanProperty
  var merchantName: String = _

  /**
    * 加密Key
    */
  @BeanProperty
  var securityKey: String = _

  /**
    * 1-生效
    * 2-失效
    */
  @BeanProperty
  var status: Int = _

  @BeanProperty
  var createdBy: String = _

  @BeanProperty
  var createdDate: Date = _

  @BeanProperty
  var updatedBy: String = _

  @BeanProperty
  var updatedDate: Date = _

  override def toString: String = {
    ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE)
  }
}
