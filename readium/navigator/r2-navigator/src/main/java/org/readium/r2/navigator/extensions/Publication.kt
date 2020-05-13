/*
 * Module: r2-navigator-kotlin
 * Developers: Mickaël Menu
 *
 * Copyright (c) 2020. Readium Foundation. All rights reserved.
 * Use of this source code is governed by a BSD-style license which is detailed in the
 * LICENSE file present in the project repository where this source code is maintained.
 */

package org.readium.r2.navigator.extensions

import org.readium.r2.shared.extensions.tryOrNull
import org.readium.r2.shared.publication.Link
import org.readium.r2.shared.publication.Publication
import java.net.URL

/** Computes an absolute URL to the given [link]. */
internal fun Publication.urlTo(link: Link): URL? {
    val baseUrl = this.baseUrl?.toString()?.removeSuffix("/")
    val urlString = if (baseUrl != null && link.href.startsWith("/")) {
        "$baseUrl${link.href}"
    } else {
        link.href
    }
    return tryOrNull { URL(urlString) }
}
