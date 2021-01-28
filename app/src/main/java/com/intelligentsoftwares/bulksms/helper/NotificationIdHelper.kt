package com.intelligentsoftwares.bulksms.helper

import java.util.concurrent.atomic.AtomicInteger


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

object NotificationIdHelper {

    private val c = AtomicInteger(0)

    fun getId(): Int = c.incrementAndGet()

}