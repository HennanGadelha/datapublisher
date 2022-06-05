package com.datapublisher.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface DataPublisherLogger

    fun getLogger(forClass: Class<*>): Logger = LoggerFactory.getLogger(forClass)

    inline fun <reified T : DataPublisherLogger> T.logger(): Logger = getLogger(T::class.java)
