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
 * An object that can convert itself to {@link ConstructiveJsonObject}.
 *
 * <p>
 * Converting object to {@link ConstructiveJsonObject} give opportunity to
 * add new elements to JSON of the current object.
 * </p>
 *
 * @since 0.1.0
 */
public interface JsonObjectConvertible {

    /**
     * Make {@link ConstructiveJsonObject}.
     *
     * @return JSON Object
     */
    ConstructiveJsonObject json();

    /**
     * A wrapper of {@link JsonObjectConvertible}.
     *
     * <p>
     * The object wrap instances of {@link JsonObjectConvertible}
     * and behaves as {@link JsonRepresentable}.
     * </p>
     *
     * @since 0.1.0
     */
    final class JsonObjectToJson implements JsonRepresentable {

        /**
         * A wrapped object.
         */
        private final JsonObjectConvertible origin;

        /**
         * Primary constructor.
         *
         * @param origin Wrapped object
         */
        public JsonObjectToJson(final JsonObjectConvertible origin) {
            this.origin = origin;
        }

        @Override
        public String toJson() {
            return this.origin.json().toJson();
        }
    }
}
