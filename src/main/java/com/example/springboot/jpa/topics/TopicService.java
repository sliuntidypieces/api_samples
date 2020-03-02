package com.example.springboot.jpa.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Bob", "description"),
			new Topic("2", "Mat", "description"), new Topic("3", "Jack", "description")));

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopicById(String id) {
		return topicRepository.findOne(id);
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
//		for (int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if (t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		
		topicRepository.save(topic); // update automatically
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}

}
