package context;

import strategy.Strategy;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 15.11.2017.
 */
public interface Context<T> {
    @Nonnull Strategy<T> getStrategy();
}