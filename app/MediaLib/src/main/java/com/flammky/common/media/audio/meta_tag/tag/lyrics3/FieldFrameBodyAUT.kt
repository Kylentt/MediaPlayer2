/**
 * @author : Paul Taylor
 * @author : Eric Farng
 *
 * Version @version:$Id$
 *
 * MusicTag Copyright (C)2003,2004
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public  License as published by the Free Software Foundation; either version 2.1 of the License,
 * or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library; if not,
 * you can get a copy from http://www.opensource.org/licenses/lgpl-license.php or write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * Description:
 */
package com.flammky.musicplayer.common.media.audio.meta_tag.tag.lyrics3

import com.flammky.musicplayer.common.media.audio.meta_tag.tag.datatype.StringSizeTerminated
import java.nio.ByteBuffer

class FieldFrameBodyAUT : AbstractLyrics3v2FieldFrameBody {
	/**
	 * Creates a new FieldBodyAUT datatype.
	 */
	constructor() {
		//        this.setObject("Author", "");
	}

	constructor(body: FieldFrameBodyAUT) : super(body)

	/**
	 * Creates a new FieldBodyAUT datatype.
	 *
	 * @param author
	 */
	constructor(author: String) {
		setObjectValue("Author", author)
	}

	/**
	 * Creates a new FieldBodyAUT datatype.
	 *
	 * @param byteBuffer
	 * @throws InvalidTagException
	 */
	constructor(byteBuffer: ByteBuffer) {
		read(byteBuffer)
	}
	/**
	 * @return
	 */
	/**
	 * @param author
	 */
	var author: String?
		get() = getObjectValue("Author") as String
		set(author) {
			setObjectValue("Author", author)
		}

	/**
	 * @return
	 */
	override val identifier: String
		get() = "AUT"

	/**
	 *
	 */
	override fun setupObjectList() {
		objectList.add(StringSizeTerminated("Author", this))
	}
}
