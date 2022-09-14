/*
 * Entagged Audio Tag library
 * Copyright (c) 2003-2005 Raphaël Slinckx <raphael@slinckx.net>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.flammky.musicplayer.common.media.audio.meta_tag.tag

import java.nio.charset.Charset

/**
 * This interface extends the default field definition by methods for working
 * with human readable text.<br></br>
 * A TagTextField does not store binary data.
 *
 * @author Rapha�l Slinckx
 */
interface TagTextField : TagField {
	/**
	 * Returns the content of the field.
	 *
	 * @return Content
	 */
	/**
	 * Sets the content of the field.
	 *
	 * @param content fields content.
	 */
	var content: String?
	/**
	 * Returns the current used charset encoding.
	 *
	 * @return Charset encoding.
	 */
	/**
	 * Sets the charset encoding used by the field.
	 *
	 * @param encoding charset.
	 */
	var encoding: Charset?
}
