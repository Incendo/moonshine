//
// moonshine - A localisation library for Java.
// Copyright (C) 2021 Mariell Hoversholm
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published
// by the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.
//

package com.proximyst.moonshine.component.placeholder;

import com.google.common.collect.Multimap;
import java.lang.reflect.Method;

/**
 * A context for a run of {@link IPlaceholderResolver#resolve(String, Object, PlaceholderContext, Multimap)}.
 *
 * @param <R> The receiver type for the {@link IPlaceholderResolver}.
 */
public final class PlaceholderContext<R> {
  private final Method method;
  private final Object proxy;
  private final Object[] parameters;

  private final R receiver;

  public PlaceholderContext(final Method method, final Object proxy, final Object[] parameters, final R receiver) {
    this.method = method;
    this.proxy = proxy;
    this.parameters = parameters;
    this.receiver = receiver;
  }

  /**
   * @return The {@link Method} called on the {@link #proxy()}.
   */
  public Method method() {
    return this.method;
  }

  /**
   * @return The proxy instance of the messaging interface.
   */
  public Object proxy() {
    return this.proxy;
  }

  /**
   * @return The parameters provided to the {@link #method()}.
   */
  public Object[] parameters() {
    return this.parameters;
  }

  /**
   * @return The receiver of type {@code R} resolved for this call.
   */
  public R receiver() {
    return this.receiver;
  }
}
