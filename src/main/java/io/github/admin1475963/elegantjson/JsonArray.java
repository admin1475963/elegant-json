/*
 * MIT License
 *
 * Copyright (c) 2021 Muhammad Ilhomov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.admin1475963.elegantjson;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple JSON array.
 *
 * @since 0.1.0
 */
public class JsonArray implements ConstructiveJsonArray {

    /**
     * Elements.
     */
    private final List<JsonRepresentable> elements;

    /**
     * Primary constructor.
     *
     * @param elements Initial elements
     */
    public JsonArray(final Collection<JsonRepresentable> elements) {
        this.elements = new LinkedList<>(elements);
    }

    /**
     * Constructor.
     */
    public JsonArray() {
        this(new LinkedList<>());
    }

    @Override
    public final String toJson() {
        return this.elements.stream()
            .map(
                element -> element.toJson()
            )
            .collect(Collectors.joining(",", "[", "]"));
    }

    @Override
    synchronized public final ConstructiveJsonArray add(
        final JsonRepresentable object
    ) {
        this.elements.add(object);
        return this;
    }
}
