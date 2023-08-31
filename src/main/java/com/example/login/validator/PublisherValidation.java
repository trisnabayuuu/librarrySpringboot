package com.example.login.validator;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.login.models.Publisher;

@Component
public class PublisherValidation {
  public void validatePublisher(Publisher publisher) {
    if (publisher == null || Objects.isNull(publisher)) {
      throw new NoSuchElementException("Publisher is not found!");
    }
  }
}
