package io.github.ronvohra;

import io.github.ronvohra.entity.Home;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface HomeResource extends PanacheEntityResource<Home, Integer> {}
