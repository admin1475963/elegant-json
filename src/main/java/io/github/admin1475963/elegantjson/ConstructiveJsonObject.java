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

/**
 * An object for constructing JSON object.
 *
 * @since 0.1.0
 */
public interface ConstructiveJsonObject extends JsonRepresentable {

    /**
     * Add a new element to JSON object.
     *
     * <p>
     * The new element must implement {@link JsonRepresentable}.
     * For adding primitives like {@code int} see classes like {@link JsonInt}.
     * </p>
     *
     * @param key Key
     * @param object Object that can be represented as JSON
     * @return New object that contains new element
     * @see JsonObject
     */
    ConstructiveJsonObject add(String key, JsonRepresentable object);
}
