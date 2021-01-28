package com.intelligentsoftwares.bulksms.roomPersistence.converters

import androidx.room.TypeConverter
import com.intelligentsoftwares.bulksms.roomPersistence.BulkSmsStatus


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
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