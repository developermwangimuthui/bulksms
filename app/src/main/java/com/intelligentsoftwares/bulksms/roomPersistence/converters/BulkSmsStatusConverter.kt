package com.intelligentsoftwares.bulksms.roomPersistence.converters

import androidx.room.TypeConverter
import com.intelligentsoftwares.bulksms.roomPersistence.BulkSmsStatus


/**
 * Ahsen Saeed}
 * ahsansaeed067@gmail.com}
 * 10/29/19}
 */

object BulkSmsStatusConverter {

    @JvmStatic
    @TypeConverter
    fun toSmsStatus(json : String) : BulkSmsStatus {
        return BulkSmsStatus.valueOf(json)
    }

    @JvmStatic
    @TypeConverter
    fun toString(status : BulkSmsStatus) : String {
        return status.name
    }
}